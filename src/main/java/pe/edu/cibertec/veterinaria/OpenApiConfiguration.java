package pe.edu.cibertec.veterinaria;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        //
        info = @Info(title = "API de Mascotasssss", //
                version = "1.0.0", //
                description = "API de mascotas de la veterinaria quekiwi", //
                contact = @Contact(email = "arthur@quekiwi.com", name = "Arthur Mauricio")), //

        servers = {
                @Server(url = "http://localhost:8080", description = "Local"),
                @Server(url = "http://127.0.3.5", description = "Desarrollo"),
                @Server(url = "https://qa.quekiwi.com", description = "QA"),
                @Server(url = "https://quekiwi.com", description = "produccion")
        }

)
public class OpenApiConfiguration {

}
