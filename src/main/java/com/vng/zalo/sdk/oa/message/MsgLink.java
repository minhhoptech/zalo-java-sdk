/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk.oa.message;

/**
 *
 * @author nghiadc
 */
public class MsgLink {

    String link; // 	String	Url của liên kết
    String linktitle;//	String	Tiêu đề của liên kết. Tối đa 100 ký tự
    String linkdes;//	String	Mô tả của liên kết. Tối đa 500 ký tự
    String linkthumb;//	String	Thumbnail của liên kết

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLinktitle() {
        return linktitle;
    }

    public void setLinktitle(String linktitle) {
        this.linktitle = linktitle;
    }

    public String getLinkdes() {
        return linkdes;
    }

    public void setLinkdes(String linkdes) {
        this.linkdes = linkdes;
    }

    public String getLinkthumb() {
        return linkthumb;
    }

    public void setLinkthumb(String linkthumb) {
        this.linkthumb = linkthumb;
    }
}
