package yuown.iseejobs.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;

public class YuownGrantedAuthority implements GrantedAuthority {

	private static final long serialVersionUID = 648120512795626447L;

	private String authority;

	public YuownGrantedAuthority() {
	}

	public YuownGrantedAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return authority;
	}
	
	@Override
	public boolean equals(Object other) {
		return StringUtils.equals(this.getAuthority(), ((YuownGrantedAuthority) other).getAuthority());
	}
}
