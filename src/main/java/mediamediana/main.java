package mediamediana;


public class main {

	public static void main(String[] args) {
		
		MyImage iobj = new MyImage();
        iobj.readImage("D:/pastilhinhas.jpg");
        Mediana.medianFilter(iobj,  3);
        iobj.writeImage("D:/tons12.jpg");
	}

}
