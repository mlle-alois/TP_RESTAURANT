import java.time.LocalDate;

/**
 * 
 * @author azimmermann
 *
 */
public class Date {
		//Attribut priv�
		private LocalDate date;
		
		//Constructeur
		/**
		 * Constructeur de la date
		 * @param uneDate
		 */
		public Date(LocalDate uneDate){
			this.date = uneDate;
		}
		
		// M�thodes
		/**
		 * Accesseur de r�cup�ration de donn�e
		 * @return date
		 */
		public LocalDate getDate(){
			return this.date;
		}
		
		/**
		 * Accesseur de r�cup�ration de donn�e
		 * @return date au format (jj/mm/aaaa)
		 */
		public String getDateFrancais(){
			return this.date.getDayOfMonth() + "/" + this.date.getMonthValue() + "/" + this.date.getYear();
		}	
}
