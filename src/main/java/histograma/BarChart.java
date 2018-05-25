package histograma;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame; 

public class BarChart extends ApplicationFrame {
   
   public BarChart( String applicationTitle , String chartTitle, int valorPreto, int valorCinzaEscuro, int valorCinza, int valorCinzaClaro, int valorbranco ) {
      super( applicationTitle );        
      JFreeChart barChart = ChartFactory.createBarChart(
         chartTitle,           
         "Categoria",            
         "Score",            
         createDataset(valorPreto, valorCinzaEscuro, valorCinza, valorCinzaClaro, valorbranco ),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );
      chartPanel.setPreferredSize(new java.awt.Dimension( 850 , 550 ) );        
      setContentPane( chartPanel ); 
      
   }
   
   private CategoryDataset createDataset(int valorPreto, int valorCinzaEscuro, int valorCinza, int valorCinzaClaro, int valorbranco ) {
      
          
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( valorPreto , "Quantidade Pixels" , "Preto: "  + valorPreto); 
      dataset.addValue( valorCinzaEscuro , "Quantidade Pixels" , "Cinza Escuro: " + valorCinzaEscuro); 
      dataset.addValue( valorCinza , "Quantidade Pixels" , "Cinza: " + valorCinza); 
      dataset.addValue( valorCinzaClaro , "Quantidade Pixels" , "Cinza Claro: " + valorCinzaClaro); 
      dataset.addValue( valorbranco , "Quantidade Pixels" , "Branco: " + valorbranco);        
        
            

      return dataset; 
   }
   
 
}