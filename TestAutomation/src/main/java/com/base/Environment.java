
package com.base;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources(
	"file:src/main/java/com/config/${env}.properties" 
)

public interface Environment extends Config{
	
	//PortalURL
	String siteURL();

	//Others
	String username();
	String password();
	String browser();
	
}
