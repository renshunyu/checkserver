package check.checkserver;
import org.apache.commons.math3.fitting.GaussianCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
public class App29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WeightedObservedPoints obs = new WeightedObservedPoints();
        obs.add(100, 25);
        obs.add(101, 68);
        obs.add(102, 144);
        obs.add(103, 220);
        obs.add(104, 335);
        obs.add(105, 199);
        obs.add(106, 52);
        obs.add(107, 14);
        obs.add(108, 5);
        obs.add(109, 2);
        
        double[] parameters = GaussianCurveFitter.create().fit(obs.toList());
        for (double i : parameters) {
            System.out.println(i);
        }
    }

}
