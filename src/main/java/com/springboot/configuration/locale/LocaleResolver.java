package com.springboot.configuration.locale;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

/**
 * Configuration class that extends the AcceptHeaderLocaleResolver to provide
 * locale resolution based on the "Accept-Language" HTTP header. This class
 * also implements the WebMvcConfigurer interface to customize the Spring MVC
 * configuration.
 * <p>
 * The LocaleResolver allows the application to automatically select the
 * appropriate locale for the user based on their preferences indicated in
 * the HTTP request. It is particularly useful for internationalization (i18n)
 * in web applications, ensuring that users receive content in their preferred
 * language.
 * <p>
 * This class can be further customized to define specific locale settings or
 * to add additional configuration related to MVC, such as interceptors or
 * formatters.
 *
 * @author Thanh
 */
@Configuration
public class LocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

	List<Locale> LOCALES = List.of(
			Locale.of("en"),
			Locale.of("fr"),
			Locale.of("vi")
	);
	/**
	 * This method is used to resolve the locale based on the "Accept-Language" header
	 * from the incoming HTTP request. It overrides the `resolveLocale` method from
	 * the `LocaleResolver` interface.
	 *
	 * @param request the HttpServletRequest object that contains the client's request
	 * @return Locale the resolved locale based on the "Accept-Language" header;
	 *         if the header is not present or empty, it defaults to Locale.US.
	 * <p>
	 * The method works as follows:
	 * 1. Retrieves the "Accept-Language" header from the HTTP request.
	 * 2. If the header is empty or null, it returns the default locale (Locale.US).
	 * 3. If the header contains a valid language value, it parses the header
	 *    using `Locale.LanguageRange.parse` to obtain language preferences.
	 * 4. It then uses `Locale.lookup` to find the best match from a predefined
	 *    set of supported locales (LOCALES) and returns the matched Locale.
	 */
	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String languageHeader = request.getHeader("Accept-Language");
		return !StringUtils.hasLength(languageHeader)
				? Locale.US
				: Locale.lookup(Locale.LanguageRange.parse(languageHeader), LOCALES);
	}
	/**
	 * Creates and configures a ResourceBundleMessageSource bean for message
	 * internationalization (i18n) in the application. This bean will be used to
	 * load messages from resource bundles, enabling the application to support
	 * multiple languages.
	 *
	 * @return ResourceBundleMessageSource configured message source.
	 * <p>
	 * The method works as follows:
	 * 1. Instantiates a new ResourceBundleMessageSource object.
	 * 2. Sets the base name of the resource bundle to "messages", which corresponds
	 *    to the properties files (e.g., messages.properties, messages_en.properties).
	 * 3. Specifies "UTF-8" as the default encoding for reading the properties files,
	 *    ensuring proper handling of international characters.
	 * 4. Enables the option to use the message code as the default message if
	 *    a specific message is not found in the resource bundle.
	 * 5. Configures caching for the loaded messages for 3600 seconds (1 hour) to
	 *    improve performance by reducing the number of file reads.
	 */
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
		rs.setBasename("messages");
		rs.setDefaultEncoding("UTF-8");
		rs.setUseCodeAsDefaultMessage(true);
		rs.setCacheSeconds(3600);
		return rs;
	}
}
