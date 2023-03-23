package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {


	private int numeroDoQuarto;
	private Date dataCheckIn;
	private Date dataCheckOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(int numeroDoQuarto, Date dataCheckIn, Date dataCheckOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}
	
	public long duration() {
		
		long diferencaEntreDatas = this.dataCheckOut.getTime()-this.dataCheckIn.getTime();		
		
		return TimeUnit.DAYS.convert(diferencaEntreDatas,TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date dataCheckIn, Date dataCheckOut) {
		
		Date dataAtual = new Date();
		
		if (  dataCheckIn.before(dataAtual) || dataCheckOut.before(dataAtual) ) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		
		if ( dataCheckIn.after(dataCheckOut)  ) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
	
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
		
		return null;
		
	}

	public int getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public Date getDataCheckIn() {
		return dataCheckIn;
	}

	public Date getDataCheckOut() {
		return dataCheckOut;
	}
	
	@Override
	public String toString() {
		return "Room " + this.numeroDoQuarto + ", check-in: " + sdf.format(dataCheckIn) + ", check-out: " + sdf.format(dataCheckOut) + ", " + this.duration() + " nights";
	}

}
