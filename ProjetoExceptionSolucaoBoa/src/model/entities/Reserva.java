package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {


	private int numeroDoQuarto;
	private Date dataCheckIn;
	private Date dataCheckOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(int numeroDoQuarto, Date dataCheckIn, Date dataCheckOut) throws DomainException {
		
		if ( dataCheckIn.after(dataCheckOut)  ) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}
	
	public long duration() {
		
		long diferencaEntreDatas = this.dataCheckOut.getTime()-this.dataCheckIn.getTime();		
		
		return TimeUnit.DAYS.convert(diferencaEntreDatas,TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date dataCheckIn, Date dataCheckOut) throws DomainException{
		
		Date dataAtual = new Date();
		
		if (  dataCheckIn.before(dataAtual) || dataCheckOut.before(dataAtual) ) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		else if ( dataCheckIn.after(dataCheckOut)  ) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		else {
			this.dataCheckIn = dataCheckIn;
			this.dataCheckOut = dataCheckOut;
		}
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
