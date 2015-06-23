package sx.cur.omnivion.lookingcase.listener;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

import sx.cur.omnivion.lookingcase.LookingCase;

public abstract class LCListener implements EventExecutor, Listener {


	protected final LookingCase i;
	protected final Class<? extends Event> clazz;
	public LCListener(LookingCase i, Class<? extends Event> clazz)
	{
		this.i = i;
		this.clazz = clazz;
	}

	public Class<? extends Event> getClazz()
	{
		return this.clazz;
	}

	@Override
	public void execute(Listener listener, Event mevent)
	{
		if (!(mevent.getClass() == this.getClazz())) return;
		this.dispatch(mevent);
	}

	public abstract void dispatch(Event mevent);


}