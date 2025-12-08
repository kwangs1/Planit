package io.choi.Planit.common.tree;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class FancyNode {
    private String title;
    private String key;
    private boolean folder;
    private List<FancyNode> children = new ArrayList<>();
}
