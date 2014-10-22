import java.util.Random;


public class timingplanes {
	public void addPlane(){

		//Randomly determine adding to queue
		Random n;
		n  = new Random();
		int m = n.nextInt(7);


		if (clock%m == 3){
			//add plane to arrival queue then move pointer from end
			a[aend] = 0;
			aend = a.length%( aend + 1) ;
			aplanes++;
		}

		if (clock%m == 4){
			//add plane to departure queue
			d[dend]= 0;
			dend = d.length%(aend +1);
			dplanes++;
		}


	}

	public void updatePlane(){
		
		//update indices
		for ( int i = 0 ; i < aplanes; i++ ){
			
			
			a[astart + i] ++;
			
			
		}




	}
}
