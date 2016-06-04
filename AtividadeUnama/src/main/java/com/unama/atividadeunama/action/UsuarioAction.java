/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unama.atividadeunama.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author douglas
 */
@Namespace("/Usuario")
@Result(name = "success", type = "json")
@ParentPackage("json-default")
public class UsuarioAction {
    
    private String nome;
    
    private String senha;
}
