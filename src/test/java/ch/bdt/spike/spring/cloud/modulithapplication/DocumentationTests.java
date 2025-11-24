package ch.bdt.spike.spring.cloud.modulithapplication;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

class DocumentationTests {


    @Test
    void writeDocumentation1() {
        ApplicationModules modules = ApplicationModules.of(ModulithApplication.class);
        Documenter.DiagramOptions vDiagramOptions = Documenter.DiagramOptions.defaults()
                                                                             .withStyle(Documenter.DiagramOptions.DiagramStyle.C4);
        // Les CanvasOptions
        Documenter.CanvasOptions vCanvasOptions = Documenter.CanvasOptions.defaults();

        new Documenter(modules).writeDocumentation(vDiagramOptions, vCanvasOptions);
    }
}