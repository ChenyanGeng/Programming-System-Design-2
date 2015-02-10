// Name:Chenyan Geng
// USC loginid:cgeng	
// CS 455 PA2
// Spring 2013
import java.util.*;
import java.lang.Math;

/**
   A polynomial. Polynomials can be added together, evaluated, and
   converted to a string form for printing.
*/
public class Poly {
    /**
       Creates the 0 polynomial
    */
    
	public Poly() {
    assert isValidPoly();
	}


    /**
       Creates polynomial with single term given
     */
    public Poly(Term term) {
	if (term.getCoeff()!=0){  // When test assert, this line should be deleted
    poly.add(term);
	}                         // When test assert, this line should be deleted
	assert isValidPoly();     
    }


    /**
       Returns the Poly that is the sum of this polynomial and b
       (neither poly is modified)
     */
    public Poly add(Poly b) {
	Poly sum = new Poly();    //return value
	int sumexpo = 0;          //exponent of one term in sum  
	double sumcoeff = 0;      //coefficioent of one term in sum
	int i=0, j=0, value = 0;  //value represents the compare result of the exponents of Poly this.poly and Poly b, it will be 0, -1 or 1
	while ((i<poly.size())&&(j<b.poly.size())){ //i is for current location in this.poly while j is for b
	 value = valCompare(((poly.get(i)).getExpon()),((b.poly.get(j)).getExpon()));
	  if(value == -1){        //Condition when exponent of b is larger
	   sum.poly.add(b.poly.get(j));
	   j++;
	   }
	  else if(value == 1){    //Condition when exponent of this.poly is larger
	   sum.poly.add(poly.get(i));
	   i++;
	   }
	  else if(value == 0){    //Condition when exponents of this.poly and b are equal
	   sumexpo = (poly.get(i)).getExpon();
	   sumcoeff = (poly.get(i)).getCoeff()+(b.poly.get(j)).getCoeff();
	   if (sumcoeff != 0){    // When test assert, this line should be deleted
	   sum.poly.add(new Term(sumcoeff,sumexpo));
	   }                      // When test assert, this line should be deleted
	   i++;
	   j++;
	   }
	  }
   
    if ((i==poly.size())&&(j!=b.poly.size())){  //Condition when terms in this.poly are all gone through but in b are not
     for(int k = j; k<b.poly.size(); k++){      //Put the left terms in b to sum
      sum.poly.add(b.poly.get(k)); 
     }
	}
  
	if ((i!=poly.size())&&(j==b.poly.size())){  //Condition when terms in b are all gone through but in this.poly are not
	 for(int k = i; k<poly.size(); k++){        //Put the left terms in this.poly to sum
      sum.poly.add(poly.get(k));
     }
    }
    
	assert isValidPoly();                       //Examine if this.poly is valid
    assert b.isValidPoly();                     //Examine if b is valid
    assert sum.isValidPoly();	                //Examine if sum is valid
	return sum;  // dummy code.  just to get stub to compile
	}

    /**
       Returns the value of the poly at a given value of x.
     */
    public double eval(double x) {
	double val = 0, c = 0;
	int e = 0;
	
	for (int i=0; i<poly.size(); i++){
	 c = (poly.get(i)).getCoeff();
	 e = (poly.get(i)).getExpon();
	 val = val+c*Math.pow(x,e);
	}
	return val;         // dummy code.  just to get stub to compile
    }

    /**
       Return a String version of the polynomial with the 
       following format, shown by exmaple:
       zero poly:   "0.0"
       1-term poly: "3.0x^2"
       4-term poly: "3.0x^5 + x^2 + 2.0x + 7.0"

       Poly is in a simplified form (only one term for any exponent),
       with no zero-coefficient terms, and terms are shown in
       decreasing order by exponent.
    */
    public String toFormattedString() {
	String s = new String();
	if (poly.size()==0){               //Condition of zero poly
	 s = "0.0.";
	}
	else{
	for (int i = 0; i<poly.size(); i++){
	 if((poly.get(i)).getExpon()==0){   //Condition when expon = 0
	  if (i==0){
	   s = Double.toString((poly.get(i)).getCoeff());
	  }
	  else {
	   s = s+"+"+(poly.get(i)).getCoeff();
	   }
	 }
	 else if((poly.get(i)).getExpon()==1){  //Condition when expon = 1
	  if (i==0){
	   s = (poly.get(i)).getCoeff()+"x";
	  }
	  else{
	   s = s+"+"+(poly.get(i)).getCoeff()+"x";
	  }
	  }
	  else if((poly.get(i)).getCoeff()==1){   //Condition when coeff = 1
	  if (i==0){
	   s = "x^"+(poly.get(i)).getExpon();
	  }
	  else{
	   s = s+"+"+"x^"+(poly.get(i)).getExpon();
	  }
	 }
	  else if((poly.get(i)).getCoeff()==-1){   //Condition when coeff = -1
	  if (i==0){
	   s = "-x^"+(poly.get(i)).getExpon();
	  }
	  else{
	   s = s+"+"+"-x^"+(poly.get(i)).getExpon();
	  }
	 }
	 else{                                    //Usual conditons
	  if (i==0){
	   s = (poly.get(i)).getCoeff()+"x^"+(poly.get(i)).getExpon();
	  }
	  else{
	   s = s+"+"+(poly.get(i)).getCoeff()+"x^"+(poly.get(i)).getExpon();
	  }
	 }
	}
	}
	return s;        // dummy code.  just to get stub to compile
    }

    // **************************************************************
    //  PRIVATE METHOD(S)

    /**
       Returns true iff the poly data is in a valid state.
    */
    private boolean isValidPoly() {
	boolean check = true;
	for (int i = 0; i<poly.size(); i++){ 
	 if ((poly.get(i)).getCoeff()==0){   //Condition when coefficient of any terms equals to 0
	  check = false;
	  System.out.println("Coefficients should not be 0");
	  break;
	 }
	 for (int j = i+1; j<poly.size();j++){   
	  if ((poly.get(i)).getExpon()<=(poly.get(j)).getExpon()){  //Condition when exponent of terms are not in a large to small order
	   check = false;
	   System.out.println("Exponents should be in large to small order");
	   break;
	  }
	 }
    }
	return check;     // dummy code.  just to get stub to compile
}

/**
       Compare x and y, then return the value representing different conditions:
	   1 represents x>y
	   0 represents x=y
	   -1 represents x<y
    */
    private int valCompare(int x, int y){ 
	 int re = 0;
	 if (x>y){
	  re = 1;
	  }
	 else if (x<y){
	  re = -1;
	 }
	 return re;
	 }
	  

    // **************************************************************
    //  PRIVATE INSTANCE VARIABLE(S)
private ArrayList<Term> poly = new ArrayList<Term>();

/* Representation Invariants
   The exponents in Terms of poly should go from large to small in order;
   Coefficient = 0 in Terms of poly is not allowed;
   Polysize>=0;
*/
   
}
