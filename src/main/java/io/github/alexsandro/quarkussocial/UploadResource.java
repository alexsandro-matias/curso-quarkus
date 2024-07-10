package io.github.alexsandro.quarkussocial;

import io.quarkus.qute.Template;
import io.quarkus.qute.html.HtmlButton;
//import io.quarkus.qute.html.HtmlInput;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


import jakarta.ws.rs.Produces;
import org.jboss.resteasy.annotations.multipartform.FormDataParam;

import static io.quarkus.devui.runtime.comms.MessageType.Response;

@Path("/upload")
public class UploadResource {

    @Template
    public static class UploadPage {
        private HtmlInput uploadFile;
        private HtmlButton submitButton;

        public HtmlInput getUploadFile() {
            return uploadFile;
        }

        public void setUploadFile(HtmlInput uploadFile) {
            this.uploadFile = uploadFile;
        }

        public HtmlButton getSubmitButton() {
            return submitButton;
        }

        public void setSubmitButton(HtmlButton submitButton) {
            this.submitButton = submitButton;
        }
    }

    @GET
    @Path("/index")
    @Produces(MediaType.TEXT_HTML)
    public UploadPage uploadPage() {
        return new UploadPage();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@FormDataParam("file") byte[] file) {
        // Process the uploaded file
        System.out.println("Uploaded file: " + Arrays.toString(file));

        return Response.ok("File uploaded successfully").build();
    }
}
