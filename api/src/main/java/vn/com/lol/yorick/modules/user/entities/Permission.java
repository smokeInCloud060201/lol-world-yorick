package vn.com.lol.yorick.modules.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import vn.com.lol.common.entities.BaseEntity;
import vn.com.lol.yorick.common.constant.HibernateConstant;

import java.util.List;

import static vn.com.lol.common.constants.GlobalHibernateConstant.IS_NOT_DELETED;
import static vn.com.lol.yorick.common.constant.HibernateConstant.Table.SOFT_DELETE_PERMISSION;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = HibernateConstant.Entity.PERMISSION)
@Table(name = HibernateConstant.Table.PERMISSION)
@SQLRestriction(IS_NOT_DELETED)
@SQLDelete(sql = SOFT_DELETE_PERMISSION)
public class Permission extends BaseEntity {
    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "rolePermission")
    private List<Role> permissionRoles;
}
