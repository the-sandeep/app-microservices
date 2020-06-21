/**
 * 
 */
package com.saan.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sandeep Maurya
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "All details about the Laptop. ")
public class Laptop implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated laptop ID")
    private Long id;

    @ApiModelProperty(notes = "The employee laptopCode")
    private String laptopCode;

    @ApiModelProperty(notes = "The employee laptop")
    private String laptop;

    private int port;

}
