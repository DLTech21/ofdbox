package com.qaqtutu.ofdbox.core.xmlobj.st;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @description: 包结构内文件路径
 * @author: 张家尧
 * @create: 2020/10/01 13:15
 */
@Data
public class ST_Loc {

    public ST_Loc() {
    }

    @NotBlank
    private String loc;

    private ST_Loc parent;

    public String getFullLoc() {
        try {
            URI uri = new URI(this.parent!=null?this.parent.getFullLoc():"/");
            return uri.resolve(new URI(this.loc)).toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return "";
    }

}