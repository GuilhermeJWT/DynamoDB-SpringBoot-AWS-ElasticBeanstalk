package br.com.systemsgs.dynamodb.model;

import java.io.Serializable;

public class ModelPessoa implements Serializable {

    private String id;
    private String name;
    private int idade;
    private String email;
    private ModelEndereco endereco;

}
