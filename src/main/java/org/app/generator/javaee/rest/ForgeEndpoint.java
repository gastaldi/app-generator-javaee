package org.app.generator.javaee.rest;

import java.nio.file.Files;
import java.nio.file.Path;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@ApplicationScoped
@javax.ws.rs.Path("/forge")
public class ForgeEndpoint {

    private static final String APPLICATION_ZIP = "application/zip";

    @GET
    @Produces("text/plain")
    public Response downloadProject() throws Exception {
        Path tempDirectory = Files.createTempDirectory("tmp");

        byte[] zipContents = null;
        return Response
                .ok(zipContents)
                .type(APPLICATION_ZIP)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"project.zip\"")
                .build();
    }
}