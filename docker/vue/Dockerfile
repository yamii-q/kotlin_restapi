FROM node:8.16-alpine

RUN echo -e "http://nl.alpinelinux.org/alpine/v3.9/main\nhttp://nl.alpinelinux.org/alpine/v3.9/community" > /etc/apk/repositories && \
    npm install -g npm && \
    npm install -g @vue/cli