import java.time.LocalDate;

/**
 * 
 * @author azimmermann
 *
 */
public class Date {
		//Attribut privé
		private LocalDate date;
		
		//Constructeur
		/**
		 * Constructeur de la date
		 * @param uneDate
		 */
		public Date(LocalDate uneDate){
			this.date = uneDate;
		}
		
		// Méthodes
		/**
		 * Accesseur de récupération de donnée
		 * @return date
		 */
		public LocalDate getDate(){
			return this.date;
		}
		
		/**
		 * Accesseur de récupération de donnée
		 * @return date au format (jj/mm/aaaa)
		 */
		public String getDateFrancais(){
			return this.date.getDayOfMonth() + "/" + this.date.getMonthValue() + "/" + this.date.getYear();
		}	
}
