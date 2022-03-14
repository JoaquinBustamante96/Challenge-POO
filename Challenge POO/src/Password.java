import java.util.Random;

public class Password {

    private int length;
    private String password; // no es necesario tener una clase con estos dos atributos
                             // ya que del atributo password se deriva su longitud
   public Password(){
       length = 8;
       generatePassword();
    }

    public Password(String password){
       this.password = password;
       length = this.password.length();
    }

   public Password(int length){
       assert  length >= 0;
       this.length = length;
       generatePassword();
   }

   private boolean containsAtLeastUpperCaseLetters(int quantity){
       int capitalLetters = 0;
       char[] password = this.password.toCharArray();
       for(int i=0; i < password.length && capitalLetters<quantity ;i++){
        if(Character.isUpperCase(password[i])){
            capitalLetters++;
           }
       }
       return capitalLetters >= quantity;
   }

   private boolean containsAtLeastLowerCaseLetters(int quantity){
       int LowerCase = 0;
       char[] password = this.password.toCharArray();
       for(int i=0; i < password.length && LowerCase<quantity ;i++){
           if(Character.isLowerCase(password[i])){
               LowerCase++;
           }
       }
       return LowerCase >= quantity;
   }

   private boolean containsAtLeastNumbers(int quantity){
       int numbers = 0;
       char[] password = this.password.toCharArray();
       for(int i=0; i < password.length && numbers<quantity ;i++){
           if(Character.isDigit(password[i])){
               numbers++;
           }
       }
       return numbers >= quantity;
   }


    public boolean isStrong(){
        return containsAtLeastUpperCaseLetters(3) &&
                containsAtLeastLowerCaseLetters(2) &&
                containsAtLeastNumbers(4);
    }

   public void generatePassword(){
       this.password = "";
       String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
               + "0123456789"
               + "abcdefghijklmnopqrstuvxyz";

       Random random = new Random();
       for (int i = 0; i<length; i++) {
           int randomNumber = random.nextInt(alphaNumeric.length()-1);
           this.password = this.password +
                   alphaNumeric
                           .substring(randomNumber, randomNumber+1);
       }
   }

    // habria que cambiar la password si se cambia su longitud
    // el problema es que hay que generar un metodo que hace dos cosas (smellcode)
    // por ejemplo setLenghtAndChangePassword()
    public void setLength(int length) {
        this.length = length;

    }

    public int getLength() {
        return length;
    }

    public String getPassword() {
        return password;
    }
}

