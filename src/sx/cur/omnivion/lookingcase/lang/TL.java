package sx.cur.omnivion.lookingcase.lang;

import sx.cur.omnivion.lookingcase.LookingCase;

public enum TL {

	
	NOT_PLAYER(LookingCase.i.getConfigRegistrar().getLocale().getMessage(Type.NOT_PLAYER)),
	SELECTOR_ENABLED(LookingCase.i.getConfigRegistrar().getLocale().getMessage(Type.SELECTOR_ENABLED)),
	SELECTOR_DISABLED(LookingCase.i.getConfigRegistrar().getLocale().getMessage(Type.SELECTOR_DISABLED)),
	ADDED_CONTAINER(LookingCase.i.getConfigRegistrar().getLocale().getMessage(Type.ADDED_CONTAINER)),
	REMOVED_CONTAINER(LookingCase.i.getConfigRegistrar().getLocale().getMessage(Type.REMOVED_CONTAINER));
	
	
	private final String string;
	
	TL(String string)
	{
		this.string = string;
	}

	public String toString()
	{
		return this.string;
	}
	
	public enum Type
	{
		NOT_PLAYER("NOT_PLAYER"),
		SELECTOR_ENABLED("SELECTOR_ENABLED"),
		SELECTOR_DISABLED("SELECTOR_DISABLED"),
		ADDED_CONTAINER("SELECTOR_DISABLED"),
		REMOVED_CONTAINER("SELECTOR_DISABLED");
		
		
		Type(String string) { }
	}
	
}