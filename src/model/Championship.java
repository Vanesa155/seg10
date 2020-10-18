package model;

public class Championship{
	
	private int year;
	private int races;
	private Pilot[] pilots; 
	
	public Championship(int year, int races){
		this.year = year;
		this.races = races;
		this.pilots = new Pilot[15];
	}
	
	public void addPilot(String name, int age, String team, int[] scores){
		boolean finish = false;
		for (int i = 0; i<pilots.length && !finish; i++){
			if (pilots[i] == null){
				pilots[i] = new Pilot(name,age,team,scores);
				finish = true;
			}
		}
	}
	
	
	public boolean findPilot(String name){
		for (int i = 0; i<pilots.length; i++){
			if (pilots[i].getName().equalsIgnoreCase(name)){
				return true;
			}
		}
		return false;
	}
	
	public String showAverageTimes(){
		String times = "";
		
		for (int i = 0; i <pilots.length; i++ ){
			if (pilots[i] == null){
				return times;
			}else{
				times += "Nombre: "+pilots[i].getName()+" promedio: "+parseAverageTime(pilots[i].calculateAverage())+"\n";
			}
		}
		return times;
	}

	private String parseAverageTime(double time){
		int seconds = (int)time%60;
		int minutes = (int)time/60;
		int hours = minutes/60;
		minutes = minutes%60;
		
		String tm = hours+" Horas: "+minutes+" Minutos: "+seconds+" Segundos: ";
		return tm;
	}
	
	public int getYear(){
		return year;
	}
	
	public int getRaces(){
		return races;
	}
}