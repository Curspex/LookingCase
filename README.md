# LookingCase
Protect a chest from the hands of your grubby users.


# API:
LookingCaseOpenEvent -- called whenever a user is about to have the LookingCase meta applied to them. If this is cancelled, the chest will open normally.

CaseUtil: (public static)
 void registerCase(Location location)
 void deleteCase(Location location)
 boolean isCase(Location location)
