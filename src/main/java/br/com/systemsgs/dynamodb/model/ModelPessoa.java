package br.com.systemsgs.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@DynamoDBTable(tableName = "pessoa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelPessoa implements Serializable {

    @DynamoDBHashKey(attributeName = "pessoaId")
    @DynamoDBAutoGeneratedKey
    private String id;

    @DynamoDBAttribute
    private String nome;

    @DynamoDBAttribute
    private int idade;

    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private ModelEndereco endereco;

}
