package com.Graduation.TeacherAssistantProject.Scheduling.evaluation;

public class EvaluationQuestion<T> {
    private String question;
    public EvaluationQuestion(String question,double priority){
    this.question=question;
    this.priority=priority;

    }
    private double priority;
    private int value;
    private boolean flag=false;

    private T questionResult;
    public double Evalaute(double priority,int value) throws Exception{
        if(priority > 1) {
        flag= true;
        }


        return value * priority;
    }
}
