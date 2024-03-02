package com.example.StudentManagementSystem.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.Date;

@Aspect
@Component
public class StudentsAspect {
    //requests get intercepted if the point cut expresion "* com.example.StudentManagementSystem.controller.CredentialsController.*(..))" evaluates to the join point we have in the function, that is the function that gets called in the Credentials Controller
    //practic iti zice de fiecare data cand functia a fost apelata inainte de se executa
    // * com.example.StudentManagementSystem.controller.CredentialsController.*(..)) - se traduce ca orice functie care returneaza orice si ia orice parametru din CredentialsController
    @Before(value = "execution(* com.example.StudentManagementSystem.controller.StudentsController.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
    }

    //Aceeasi chestie doar ca acum afiseaza dupa ce s-a facut request ul
    @After(value = "execution(* com.example.StudentManagementSystem.controller.StudentsController.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + new Date());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

}
