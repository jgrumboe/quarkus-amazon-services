package io.quarkiverse.amazon.common.deployment.spi;

/**
 * Well-known AWS service names for dev services container configuration.
 * This is a local replacement for the removed LocalStackContainer.Service enum.
 */
public enum Service implements EnabledService {
    S3("s3"),
    SQS("sqs"),
    SNS("sns"),
    STS("sts"),
    SSM("ssm"),
    SES("ses"),
    STEPFUNCTIONS("stepfunctions"),
    SECRETSMANAGER("secretsmanager"),
    LAMBDA("lambda"),
    IAM("iam"),
    KMS("kms"),
    KINESIS("kinesis"),
    DYNAMODB("dynamodb"),
    CLOUDWATCH("cloudwatch"),
    CLOUDWATCHLOGS("logs");

    private final String name;

    Service(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPort() {
        return 4566;
    }
}
