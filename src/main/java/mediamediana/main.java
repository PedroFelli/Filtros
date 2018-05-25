package mediamediana;


public class main {

	public static void main(String[] args) {
		
		MyImage iobj = new MyImage();
        iobj.readImage("");
        Mediana.medianFilter(iobj,  3);
        iobj.writeImage("");
	}

}
