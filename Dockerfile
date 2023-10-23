FROM gradle:7.1.1-jdk11 AS BUILD_IMAGE
# Python install
COPY --from=python:3.12.0a5-bullseye / /
RUN pip install --no-cache-dir --upgrade pip && \
    pip install --no-cache-dir pymongo && \
    pip install --upgrade pymongo

RUN mkdir /apps
COPY . /apps
WORKDIR /apps

RUN gradle clean build

CMD bash startup.sh
