package org.app.generator.javaee;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;

import org.jboss.forge.service.producer.FurnaceProducer;
import org.jboss.forge.service.producer.FurnaceServiceProducer;

/**
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
public class AppExtension implements Extension {

    public void vetoFurnaceProducer(@Observes ProcessAnnotatedType<FurnaceProducer> furnaceProducer) {
        furnaceProducer.veto();
    }

    public void vetoFurnaceServiceProducer(@Observes ProcessAnnotatedType<FurnaceServiceProducer> furnaceServiceProducer) {
        furnaceServiceProducer.veto();
    }
}
