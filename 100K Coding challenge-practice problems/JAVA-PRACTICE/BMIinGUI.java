import javax.swing.JOptionPane;

public class BMIinGUI {
    public static void main(String ar[]) {
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height in meters"));
        double weight = Double.parseDouble(JOptionPane.showInputDialog("Enter your weight in Kg"));

        double BMI = (weight / (height * height));

        JOptionPane.showMessageDialog(null, "Your BMI is " + BMI);

        if (BMI<18.5) {
            JOptionPane.showMessageDialog(null, "You are underweight");
        } else if (BMI<25) {
            JOptionPane.showMessageDialog(null, "You are healthy");
        } else {
            JOptionPane.showMessageDialog(null, "You are overweight");
        }
    } 

}
