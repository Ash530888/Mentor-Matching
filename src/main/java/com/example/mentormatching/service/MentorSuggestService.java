package com.example.mentormatching.service;

import java.lang.Math;
import com.example.mentormatching.dao.UserDAO;
import com.example.mentormatching.model.*;
import com.example.mentormatching.model.test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class MentorSuggestService {

    @Autowired
    UserDAO repo;



    public double calculateMatchRate(User mentee, User mentor){
        TestMenteeProfile menteeProfileEx = mentee.getTestMenteeProfile();
        TestProfile menteeProfileDef = mentee.getTestProfile();

        TestMentorProfile mentorProfileEx = mentor.getTestMentorProfile();
        TestProfile mentorProfileDef = mentor.getTestProfile();

        List<Double> scores = new ArrayList<>();
        List<Double> weightings = new ArrayList<>();
        try {
            double mentorAgeMatchRate = doubleMatchRate(Double.parseDouble(menteeProfileEx.getPreferredMentorAge()),
                    Double.parseDouble(mentorProfileDef.getAge()));
            scores.add(mentorAgeMatchRate);
        }
        catch(NullPointerException ignored){scores.add(0.0);}

        try {
            double menteeAgeMatchRate = doubleMatchRate(Double.parseDouble(mentorProfileEx.getPreferredMenteeAge()),
                    Double.parseDouble(menteeProfileDef.getAge()));
            scores.add(menteeAgeMatchRate);
        }
        catch(NullPointerException ignored){scores.add(0.0);}

        try {
            double mentorGenderMatchRate = strictStringComparisonRate(menteeProfileEx.getPreferredMentorGender(),
                    mentorProfileDef.getGender());
            scores.add(mentorGenderMatchRate);
        }
        catch(NullPointerException ignored){scores.add(0.0);}

        try {
            double menteeGenderMatchRate = strictStringComparisonRate(mentorProfileEx.getPreferredMenteeGender(),
                    menteeProfileDef.getGender());
            scores.add(menteeGenderMatchRate);
        }
        catch(NullPointerException ignored){scores.add(0.0);}

        try {
            double languageMatchRate = stringInArray(menteeProfileEx.getPreferredLanguage(),
                    mentorProfileDef.getLanguages().split(" "));
            scores.add(languageMatchRate);
        }
        catch(NullPointerException ignored){scores.add(0.0);}

        // a very complicated expression to find the closest string match to mentee's preferred job for the mentor
        try {
            double menteePositionMatch = Math.min(Math.min(stringLevenshteinComparisonRate(
                                    menteeProfileEx.getPreferredMentorPosition(), mentorProfileDef.getJobPosition()),
                            stringLevenshteinComparisonRate(menteeProfileEx.getPreferredMentorPosition(),
                                    mentorProfileDef.getFieldOfWork())),
                    stringLevenshteinComparisonRate(menteeProfileEx.getPreferredMentorPosition(),
                            mentorProfileDef.getPastJobs()));
            scores.add(menteePositionMatch);
        }
        catch(IllegalArgumentException ignored){scores.add(0.0);}

        try {
            double mentorPositionMatch = Math.min(Math.min(stringLevenshteinComparisonRate(
                                    mentorProfileEx.getPreferredMenteeRole(), menteeProfileDef.getJobPosition()),
                            stringLevenshteinComparisonRate(mentorProfileEx.getPreferredMenteeRole(),
                                    menteeProfileDef.getFieldOfWork())),
                    stringLevenshteinComparisonRate(mentorProfileEx.getPreferredMenteeRole(),
                            menteeProfileDef.getPastJobs()));
            scores.add(mentorPositionMatch);
        }
        catch(IllegalArgumentException ignored){scores.add(0.0);}


        double sum = 0;
        for (double doub : scores){
            sum += doub;
        }
        return sum/(double)scores.size();
    }

    public List<User> sortMentors(List<User> mentors, User mentee) {
        List<User> sortedMentors = new ArrayList<User>(mentors);
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Double.compare(calculateMatchRate(o2,mentee), calculateMatchRate(o1, mentee));
            }
        };
        sortedMentors.sort(comparator);
        return sortedMentors;
    }


    public double doubleMatchRate(double base, double comparator){
        double quadratic = Math.pow((base-comparator),2);
        double normalScaling = (-1.0)/100.0;
        return Math.max(normalScaling * (quadratic - 100), 0);
    }

    public double strictStringComparisonRate(String base, String comparator){
        return (base.equals(comparator) ? 1 : 0);
    }

    public double stringInArray(String base, String[] comparator){
        boolean inArray = false;
        for (String str : comparator){
            if (str.equals(base)){
                inArray = true;
                break;
            }
        }
        return (inArray ? 1 : 0);
    }

    public double stringLevenshteinComparisonRate(String base, String comparator){
        return StringUtils.getLevenshteinDistance(base, comparator)/(double)Math.max(base.length(), comparator.length());
    }
    public double stringLevenshteinComparisonRate(String base, String[] comparator){
        double min = StringUtils.getLevenshteinDistance(base,
                comparator[0])/(double)(base.length()+comparator[0].length());
        for (int i = 1; i < comparator.length; i++){
            min = Math.min(min, StringUtils.getLevenshteinDistance(base,
                    comparator[i])/(double)(base.length() + comparator[0].length()));
        }
        return min;
    }


}

