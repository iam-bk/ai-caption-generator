# Caption Generator

This is a Spring Boot application that generates captions for images using a machine learning model hosted on AWS SageMaker.

## How it works

The application exposes a single REST API endpoint that accepts an image URL. It then sends the image URL to a SageMaker endpoint, which returns a generated caption.

## API

### Generate a caption

**POST** `/api/v1/caption`

**Request body**

```json
{
  "imageUrl": "https://example.com/image.jpg"
}
```

**Success response**

**Code** `200 OK`

**Content**

```json
"a cat sitting on a couch"
```

## Getting started

To run the application, you will need to have Java 17 and Gradle installed.

1.  Clone the repository.
2.  In `src/main/java/com/zepic/captiongenerator/CredentialProvider.java`, replace the placeholder AWS credentials with your own.
3.  In `src/main/java/com/zepic/captiongenerator/CaptionServiceImpl.java`, replace the `<ENDPOINT_NAME>` placeholder with your SageMaker endpoint name.
4.  Run the application using `./gradlew bootRun`.

## Security considerations

The AWS credentials are currently hardcoded in the source code. This is a security risk. In a production environment, you should use a more secure method of providing credentials, such as environment variables or IAM roles.