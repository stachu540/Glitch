package glitch.kraken.services;

import com.google.gson.JsonObject;
import glitch.service.AbstractHttpService;
import glitch.auth.GlitchScope;
import glitch.auth.objects.json.Credential;
import glitch.kraken.GlitchKraken;
import glitch.kraken.object.json.Video;
import glitch.kraken.object.json.list.Videos;
import glitch.kraken.object.json.requests.VideoBody;
import glitch.kraken.services.request.FollowedVideosRequest;
import glitch.kraken.services.request.TopVideosRequest;
import reactor.core.publisher.Mono;

public class VideoService extends AbstractHttpService {
    public VideoService(GlitchKraken rest) {
        super(rest.getClient(), rest.getHttpClient());
    }

    public Mono<Video> getVideo(Long id) {
        return exchange(get(String.format("/videos/%s", id), Video.class)).toMono();
    }

    public TopVideosRequest getTopVideos() {
        return new TopVideosRequest(http, get("/videos/top", Videos.class));
    }

    public FollowedVideosRequest getTopVideos(Credential credential) {
        return new FollowedVideosRequest(http, get("/videos/followed", Videos.class), credential);
    }

    public void createUpload(Credential credential) {
        throw new UnsupportedOperationException("Uploading videos is currently not supported. Checkout GitHub feature issues: https://github.com/GlitchLib/glitch/issues/25");
    }

    public Mono<Video> updateVideo(Long id, Credential credential, VideoBody body) {

        return Mono.just(checkRequiredScope(credential.getScopes(), GlitchScope.CHANNEL_EDITOR))
                .flatMap(b -> {
                    if (b) {
                        return exchange(put(String.format("/videos/%s", id), Video.class)
                                .body(body)
                                .queryParam("Authorization", "OAuth " + credential.getAccessToken()))
                                .toMono();
                    } else {
                        return Mono.error(handleScopeMissing(GlitchScope.CHANNEL_EDITOR));
                    }
                });
    }

    public Mono<Boolean> delete(Video video, Credential credential) {
        return Mono.just(checkRequiredScope(credential.getScopes(), GlitchScope.CHANNEL_EDITOR))
                .flatMap(b -> {
                    if (b) {
                        return exchange(delete(String.format("/videos/%s", video.getId()), JsonObject.class)
                                .queryParam("Authorization", "OAuth " + credential.getAccessToken()))
                                .toMono(o -> o.get("ok").getAsBoolean());
                    } else {
                        return Mono.error(handleScopeMissing(GlitchScope.CHANNEL_EDITOR));
                    }
                });
    }
}
