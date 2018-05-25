package filtros;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import org.jfree.ui.RefineryUtilities;

import histograma.BarChart;
import mediamediana.Media;
import mediamediana.Mediana;
import mediamediana.MyImage;

public class FiltrosJanela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiltrosJanela frame = new FiltrosJanela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FiltrosJanela() {
		final JButton selecDiretorio = new JButton("");
//		setIconImage(Toolkit.getDefaultToolkit().getImage(FiltrosJanela.class.getResource("/assets/uni.png")));
		setTitle("UniEvangelica - Filtros de Média e Mediana\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final JFileChooser chooser = new JFileChooser();
		final JFileChooser chooser2 = new JFileChooser();

		
		Label label = new Label("Insira a imagem: ");
		label.setBounds(10, 29, 94, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Salvar resultado: ");
		label_1.setBounds(10, 67, 107, 22);
		contentPane.add(label_1);
		
		selecDiretorio.setBounds(375, 28, 49, 23);
		contentPane.add(selecDiretorio);
		selecDiretorio.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		selecDiretorio.setBackground(SystemColor.controlHighlight);
		
	    final JButton selecDiretorio2 = new JButton("");
	    selecDiretorio2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
	    selecDiretorio2.setBackground(SystemColor.controlHighlight);
	    selecDiretorio2.setBounds(375, 66, 49, 23);
	    contentPane.add(selecDiretorio2);
		
	    ImageIcon Imagedir = new ImageIcon(Media.class.getResource("/assets/Elegantes_0020_Folder.png"), "dir" );
	    selecDiretorio2.setIcon(Imagedir);
		selecDiretorio.setIcon(Imagedir);
		
	    final TextField areaDiretorio = new TextField();
		areaDiretorio.setBounds(126, 31, 222, 20);
		contentPane.add(areaDiretorio);
		areaDiretorio.setColumns(10);
		
	    final TextField areaDiretorio2 = new TextField();
	    areaDiretorio2.setColumns(10);
	    areaDiretorio2.setBounds(126, 69, 222, 20);
	    contentPane.add(areaDiretorio2);
		
		final JRadioButton media = new JRadioButton("Média");
		media.setBounds(194, 108, 63, 23);
		contentPane.add(media);	
		
		final JRadioButton mediana = new JRadioButton("Mediana");
		mediana.setBounds(287, 108, 80, 23);
		contentPane.add(mediana);

		
		//Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(mediana);
	    group.add(media);
	    media.setSelected(true);

	    Label label_2 = new Label("Selecione o tipo de filtro: ");
	    label_2.setBounds(10, 109, 153, 22);
	    contentPane.add(label_2);
	    
	    Label label_3 = new Label("Selecione a máscara: ");
	    label_3.setBounds(10, 151, 153, 22);
	    contentPane.add(label_3);
	    
	    final JRadioButton x3 = new JRadioButton("3x3");
	    x3.setBounds(169, 150, 63, 23);
	    contentPane.add(x3);
	    
	    final JRadioButton x5 = new JRadioButton("5x5");
	    x5.setBounds(254, 150, 63, 23);
	    contentPane.add(x5);
	    
	    final JRadioButton x9 = new JRadioButton("9x9");
	    x9.setBounds(338, 151, 63, 23);
	    contentPane.add(x9);
	    
	    ButtonGroup group2 = new ButtonGroup();
	    group2.add(x3);
	    group2.add(x5);
	    group2.add(x9);
	    x3.setSelected(true);
	    
	    

	    


		selecDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Selecione a imagem: ");
			    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			    	String selected = chooser.getSelectedFile().toString();
			    	areaDiretorio.setText(selected);
			    	areaDiretorio.setEditable(false);
			    }else {
			    	JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado");
			    }
			}
		});
		
		selecDiretorio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				chooser2.setCurrentDirectory(new java.io.File("."));
				chooser2.setDialogTitle("Selecione a pasta para salvar a imagem: ");
				chooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser2.setAcceptAllFileFilterUsed(false);
			    
				if (chooser2.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			    	String selected = chooser2.getSelectedFile().toString();
			    	areaDiretorio2.setText(selected);
			    	areaDiretorio2.setEditable(false);
			    }else {
			    	JOptionPane.showMessageDialog(null, "Nenhum diretório selecionado");
			    }
			}
		});
		
		final JButton aplicar = new JButton("Aplicar Filtro");
		aplicar.setBounds(126, 211, 179, 22);
		aplicar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		aplicar.setBackground(SystemColor.controlHighlight);
		contentPane.add(aplicar);
		
		aplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (areaDiretorio.getText().isEmpty() || areaDiretorio2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos");
				} else {
				
				int mascara = 3;
				if(x3.isSelected()){
					mascara = 3;
				} else if (x5.isSelected()) {
					mascara = 5;
				} else if (x9.isSelected()) {
					mascara = 9;
				}
				if(media.isSelected()){
					MyImage iobj = new MyImage();
			        iobj.readImage(areaDiretorio.getText());
			        Media.meanFilter(iobj,  mascara);
			        iobj.writeImage(areaDiretorio2.getText() + "/filtroAplicado.png");
			        File file = new File(areaDiretorio2.getText() + "/filtroAplicado.png");
			        try {
						GerarHistograma(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
			        ShowImage mostrar = new ShowImage();
			        try {
						mostrar.MostraImagem(file, "Filtro Aplicado" );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        
				} else if (mediana.isSelected()){ 
					MyImage iobj = new MyImage();
			        iobj.readImage(areaDiretorio.getText());
			        Mediana.medianFilter(iobj,  mascara);
			        iobj.writeImage(areaDiretorio2.getText() + "/filtroAplicado.png");
			        File file = new File(areaDiretorio2.getText() + "/filtroAplicado.png");
			        try {
						GerarHistograma(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        ShowImage mostrar = new ShowImage();
			        try {
						mostrar.MostraImagem(file, "Filtro Aplicado" );
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			}
		});
		
	}
	
    
    static public void GerarHistograma(File file) throws IOException{
    	BufferedImage img = ImageIO.read(file);
        int width = img.getWidth();
        int height = img.getHeight();
        int CountAll = 0;
        int CountPreto = 0;
        int CountBranco = 0;
        int CountCinza = 0;
        int CountCinzaEscuro = 0;
        int CountCinzaClaro = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
            	Color Pixel = new Color(img.getRGB(i, j));
            	
            	 if((Pixel.getRed() == Pixel.getGreen()) && (Pixel.getRed() == Pixel.getBlue())){
            		 
            		 if(Pixel.getRed() == 0){
            			 CountPreto++;
            		 } else if (Pixel.getRed() >= 1 && Pixel.getRed() < 85){
            			 CountCinzaEscuro++;
            		 } else if (Pixel.getRed() >= 85 && Pixel.getRed() < 170){
            			 CountCinza++;
            		 } else if (Pixel.getRed() >= 170 && Pixel.getRed() < 255){
            			 CountCinzaClaro++;
            		 } else if (Pixel.getRed() == 255){
            			 CountBranco++;
            		 }
            		 
 
            	CountAll++;                    
               }

            }
        }
     
        
      //Gerando Histograma
        BarChart chart = new BarChart("Dados da imagem selecionada", "Escala de cinza da imagem", CountPreto, CountCinzaEscuro, CountCinza, CountCinzaClaro, CountBranco);
        chart.pack( );        
        RefineryUtilities.centerFrameOnScreen( chart );        
        chart.setVisible( true );
    }
}
