package it.cosenonjaviste.sparktutorial;

import spark.Spark;

public class App 
{
    public static void main( String[] args )
    {
    	Spark.get("/hello", (request, response) -> "Hello World");
    }
}
