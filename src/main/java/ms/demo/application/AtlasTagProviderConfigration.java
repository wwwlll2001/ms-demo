package ms.demo.application;

import com.netflix.spectator.api.Registry;
import com.netflix.spectator.api.Spectator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.netflix.metrics.atlas.AtlasTagProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

@Configuration
public class AtlasTagProviderConfigration {
    @Bean
    AtlasTagProvider atlasCommonTags(@Value("${spring.application.name}") String appName) {
        return () -> Collections.singletonMap("app", appName);
    }

//    @Bean
//    public CommandLineRunner registerExtMetrics(Registry registry) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... strings) throws Exception {
//                Jmx.registerStandardMXBeans(registry);
//                Spectator.globalRegistry().add(registry);
//                GcLogger gc = new GcLogger();
//                gc.start(null);
//            }
//        };
//    }

    public static void main(String[] args) {
        AtlasTagProviderConfigration atlasTagProviderConfigration = new AtlasTagProviderConfigration();
        Map<String, String> tags = atlasTagProviderConfigration.atlasCommonTags("123").defaultTags();
        tags.keySet().forEach(System.out::println);

    }
}