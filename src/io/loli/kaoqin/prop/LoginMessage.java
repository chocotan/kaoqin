package io.loli.kaoqin.prop;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LoginMessage {
	private static final String BUNDLE_NAME = "io.loli.kaoqin.prop.login"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private LoginMessage() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
