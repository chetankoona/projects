package com.ckdemo.coronavirustracker;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GitHubService {
    private final WebClient webClient;

    public GitHubService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://raw.githubusercontent.com").build();
    }

    public Mono<String> getCovidInfectedData(){
        return this.webClient.get().uri("/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv")
                .retrieve().bodyToMono(String.class);
    }
}
