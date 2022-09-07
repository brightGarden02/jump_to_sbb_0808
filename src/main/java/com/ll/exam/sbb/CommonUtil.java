package com.ll.exam.sbb;

import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

@Component
public class CommonUtil {

    public String markdown(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}
