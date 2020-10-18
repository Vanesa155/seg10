package model;

public class Pilot{
	
	private String name;
	private int age;
	private int[] scores;
	Team team;
	
	public Pilot(String name, int age, String tm, int[] scores){
		this.name = name;
		this.age = age;
		this.team = Team.valueOf(tm);
		this.scores = scores;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public int[] getScores(){
		return scores;
	}
	
	public String getTeam(){
		return team+"";
	}
	
	public double calculateAverage(){
		double total = 0;
		for (int i = 0; i<scores.length; i++){
			total += scores[i];
		}
		total = total/scores.length;
		return total;
	}
}