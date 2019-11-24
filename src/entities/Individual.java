package entities;

public class Individual extends TaxPayer{

	protected Double healthExpeditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpeditures) {
		super(name, anualIncome);
		this.healthExpeditures = healthExpeditures;
	}
	
	public Double getHealthExpeditures() {
		return healthExpeditures;
	}
	
	public void setHeathExpeditures(Double healthExpeditures) {
		this.healthExpeditures = healthExpeditures;
	}
	
	@Override
	public Double tax() {
		if (getAnualIncome()<20000) {
			return getAnualIncome() * 0.15 - healthExpeditures * 0.5;
		} else {
			return getAnualIncome() * 0.25 - healthExpeditures * 0.5;
		}
	}
}
