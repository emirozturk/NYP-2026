public class SWChar{
    private String name;
    private String side;
    private String lightsaberColor;
    private String planet;
    public int age;
    
    public static int charCount=0; 
    public SWChar(String name){
        this.name = name;
        charCount++;
    }
    public SWChar(String name,String side){
        this.name = name;
        this.side = side;
        charCount++;
    }
    public static SWChar createCharWithNameAndLightsaber(String name,String lightsaberColor){
        return new SWChar(name,"", lightsaberColor,"", 0);
    }
    public SWChar(String name,int age){
        charCount++;
    }
    public SWChar(int age,String lightsaberColor){
        charCount++;
    }
    public SWChar(String name,String side,String lightsaberColor,String planet,int age){
        this.name = name;
        this.side = side;
        this.lightsaberColor = lightsaberColor;
        this.planet =planet;
        this.age = age;
        charCount++;
    }
    public String toString(){
        return String.format("%s %s %s %s %d", name, side, lightsaberColor, planet, age);
    }
}