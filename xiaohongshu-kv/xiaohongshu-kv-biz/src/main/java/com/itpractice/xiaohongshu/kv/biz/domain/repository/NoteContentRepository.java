package com.itpractice.xiaohongshu.kv.biz.domain.repository;

import com.itpractice.xiaohongshu.kv.biz.domain.dataobject.NoteContentDO;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/**
 * @author cyb
 *
 *
 */
public interface NoteContentRepository extends CassandraRepository<NoteContentDO, UUID> {
}
