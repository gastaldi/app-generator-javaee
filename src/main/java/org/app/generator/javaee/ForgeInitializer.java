package org.app.generator.javaee;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.jboss.forge.addon.projects.Projects;

/**
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
@WebListener
public class ForgeInitializer implements ServletContextListener {
    private static final transient Logger log = Logger.getLogger(ForgeInitializer.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            // Skip unnecessary build status checks in Forge
            System.setProperty("PROJECT_BUILDSTATUS_SKIP", "true");
            // Disable all kind of internal project caching
            Projects.disableCache();
            // Create a temp file to store the configuration properties
            File tmpFile = File.createTempFile("config", ".properties");
            tmpFile.deleteOnExit();
            System.setProperty("org.jboss.forge.addon.configuration.USER_CONFIG_PATH", tmpFile.getAbsolutePath());
        } catch (IOException e) {
            log.log(Level.SEVERE, "Error while setting up Furnace", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
