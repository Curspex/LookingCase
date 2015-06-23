package sx.cur.omnivion.lookingcase.configuration;

import sx.cur.omnivion.lookingcase.LookingCase;

public class LCPrimary extends LCConfiguration {


	public LCPrimary(LookingCase i, String fileName)
	{
		super(i, fileName);
		super.cns();
	}

	@Override
	protected void populate()
	{
		this.setinventoryRefreshTickDelay(super.config.getLong("refreshTickDelay"));
		this.setRegisterOnSneak(super.config.getBoolean("registerOnSneak"));
		this.setRemoveOnBreak(super.config.getBoolean("removeOnBreak"));
	}

	private long refreshTickDelay = 1L;
	public long getRefreshTickDelay() { return this.refreshTickDelay; }
	public void setinventoryRefreshTickDelay(final long newRefreshTickDelay) { this.refreshTickDelay = newRefreshTickDelay; }
	
	private boolean registerOnSneak = false;
	public boolean getRegisterOnSneak() { return this.registerOnSneak; }
	public void setRegisterOnSneak(final boolean newRegisterOnSneak) { this.registerOnSneak = newRegisterOnSneak; }
	
	private boolean removeOnBreak = false;
	public boolean getRemoveOnBreak() { return this.removeOnBreak; }
	public void setRemoveOnBreak(final boolean newRemoveOnBreak) { this.removeOnBreak = newRemoveOnBreak; }



}