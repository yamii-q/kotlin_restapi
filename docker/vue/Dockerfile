FROM node:8.16-alpine

RUN rm -rf /var/cache/apk/* && \
    rm -rf /tmp/* && \
    apk update && \
    npm install -g npm && \
    npm install -g @vue/cli